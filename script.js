document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("requestForm");

    // Submit new request
    form.addEventListener("submit", function (e) {
        e.preventDefault();

        const data = {
            name: document.getElementById("name").value,
            age: parseInt(document.getElementById("age").value),
            location: document.getElementById("location").value,
            contact: document.getElementById("contact").value,
            emergencyType: document.getElementById("emergency").value
        };

        fetch("http://localhost:8080/api/request", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(data)
        })
        .then(response => response.text())
        .then(msg => {
            alert(msg);
            form.reset();
            fetchRequests(); // refresh table after submission
        })
        .catch(error => {
            console.error("Error:", error);
            alert("Something went wrong!");
        });
    });
});

// Fetch all requests and display in table
function fetchRequests() {
    fetch("http://localhost:8080/api/requests")
        .then(response => response.json())
        .then(data => {
            const tbody = document.querySelector("#requestTable tbody");
            tbody.innerHTML = ""; // clear table

            data.forEach(req => {
                const tr = document.createElement("tr");
                tr.innerHTML = `
                    <td>${req.requestId}</td>
                    <td>${req.user.name}</td>
                    <td>${req.user.age}</td>
                    <td>${req.user.location}</td>
                    <td>${req.user.contact}</td>
                    <td>${req.emergencyType}</td>
                    <td>${req.status}</td>
                `;
                tbody.appendChild(tr);
            });
        })
        .catch(err => {
            console.error("Error fetching requests:", err);
            alert("Failed to load requests!");
        });
}
