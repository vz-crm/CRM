document.addEventListener('DOMContentLoaded', () => {
    const customerId = new URLSearchParams(window.location.search).get('id');
    
    if (customerId) {
        fetch(`/customers/${customerId}`)
            .then(response => response.json())
            .then(customer => {
                document.getElementById('customer-details').innerHTML = `
                    <p><strong>ID:</strong> ${customer.id}</p>
                    <p><strong>Name:</strong> ${customer.name}</p>
                    <p><strong>Email:</strong> ${customer.email}</p>
					<p><strong>Phone:</strong> ${customer.phone}</p>
                    <a href="index.html" class="btn">Back to List</a>
                `;
            })
            .catch(error => console.error('Error fetching customer details:', error));
    }
});
