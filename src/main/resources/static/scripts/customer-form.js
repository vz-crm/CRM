document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('customer-form');
    const customerId = new URLSearchParams(window.location.search).get('id');

    if (customerId) {
        fetch(`/customers/${customerId}`)
            .then(response => response.json())
            .then(customer => {
                document.getElementById('customer-id').value = customer.id;
                document.getElementById('name').value = customer.name;
                document.getElementById('email').value = customer.email;
				document.getElementById('phone').value = customer.phone;

            })
            .catch(error => console.error('Error fetching customer:', error));
    }

    form.addEventListener('submit', event => {
        event.preventDefault();
        
        const id = document.getElementById('customer-id').value;
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
		const phone = document.getElementById('phone').value;

        const method = id ? 'PUT' : 'POST';
        const url = id ? `/customers/${id}` : '/customers';
        
        fetch(url, {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ name, email, phone})
        })
        .then(response => response.json())
        .then(() => window.location.href = 'index.html')
        .catch(error => console.error('Error saving customer:', error));
    });
});
