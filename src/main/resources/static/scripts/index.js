document.addEventListener('DOMContentLoaded', () => {
    fetch('/customers')
        .then(response => response.json())
        .then(customers => {
            const tableBody = document.getElementById('customer-table-body');
            tableBody.innerHTML = customers.map(customer => `
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.name}</td>
                    <td>${customer.email}</td>
					<td>${customer.phone}</td>
                    <td>
                        <a href="customer-details.html?id=${customer.id}" class="btn">View</a>
                        <a href="customer-form.html?id=${customer.id}" class="btn">Edit</a>
                    </td>
                </tr>
            `).join('');
        })
        .catch(error => console.error('Error fetching customers:', error));
});
