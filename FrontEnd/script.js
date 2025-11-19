const api = "http://localhost:5566/api/students";

async function loadStudents() {
    try{
        const res = await fetch(api);
        const data = await res.json();
        let html = "<tr><th>ID</th><th>Name</th><th>Email</th><th>Action</th></tr>";

        data.forEach(s => {
            html +=` <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.email}</td>
                <td>
                    <button onClick="deleteStudent(${s.id})">Delete</button></td></tr>`;
        });

        document.getElementById("studentTable").innerHTML = html;
    }catch(err){
        console.error(err);
        document.getElementById("studentTable").innerHTML = "<tr><td colspan='4'>Cannot load students</td></tr>";
    }
}
document.getElementById("addBtn").addEventListener("click",addStudent);

async function addStudent() {
    const name = document.getElementById("name").value.trim();
    const email = document.getElementById("email").value.trim();

        if(!name || !email)
        {
            alert("Enter name and email");
            return;
        }

        const student = {name , email};

        await fetch(api, {
            method : "POST",
            headers: {  "Content-Type":"application/json"},
            body: JSON.stringify(student)
        });

        document.getElementById("name").value = "";
        document.getElementById("email").value = "";
        loadStudents();
}
async function deleteStudent(id) {
    if(!confirm("Delete student?"))return;
    await fetch(`${api}/${id}`,
        {
        method: "DELETE" });
        loadStudents();
}

loadStudents();