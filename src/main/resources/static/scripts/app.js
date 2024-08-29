document.addEventListener('DOMContentLoaded', () => {
    fetchCustomers();
});

function fetchCustomers() {
    fetch('/customers')
        .then(response => response.json())
        .then(data => {
            const customerList = document.getElementById('customerList');
            customerList.innerHTML = '';
            data.forEach(customer => {
                const listItem = document.createElement('li');
                listItem.textContent = `(${customer.name}) (${customer.email}) (${customer.phone})`;
                listItem.innerHTML += ` <button onclick="editCustomer(${customer.id})">Edit</button>`;
                customerList.appendChild(listItem);
            });
        })
        .catch(error => console.error('Error fetching customers:', error));
}

function handleSubmit(event) {
    event.preventDefault();

    const id = document.getElementById('customerId').value;
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
	const phone = document.getElementById('phone').value;


    const url = id ? `/customers/${id}` : '/customers';
    const method = id ? 'PUT' : 'POST';
    
    fetch(url, {
        method: method,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ name, email,phone })
    })
    .then(response => {
        if (response.ok) {
            fetchCustomers();
            document.getElementById('customerForm').reset();
            document.getElementById('customerId').value = '';
        } else {
            console.error('Error saving customer:', response.statusText);
        }
    })
    .catch(error => console.error('Error:', error));

    return false;
}

function editCustomer(id) {
    fetch(`/customers/${id}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById('customerId').value = data.id;
            document.getElementById('name').value = data.name;
            document.getElementById('email').value = data.email;
			document.getElementById('phone').value = data.phone;

        })
        .catch(error => console.error('Error fetching customer:', error));
}

