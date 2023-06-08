// Obtener los productos mediante una petición a la API
fetch('/productos/todos')
    .then(response => response.json())
    .then(data => {
        const productosTable = document.getElementById('productosTable');

        data.forEach(producto => {
            const row = document.createElement('tr');
            row.setAttribute('data-producto-id', producto.idProducto);

            const nombreCell = document.createElement('td');
            nombreCell.textContent = producto.nombre_producto;
            row.appendChild(nombreCell);

            const cantidadDisponibleCell = document.createElement('td');
            cantidadDisponibleCell.textContent = producto.cantidad;
            row.appendChild(cantidadDisponibleCell);

            const cantidadInputCell = document.createElement('td');
            const cantidadInput = document.createElement('input');
            cantidadInput.type = 'number';
            cantidadInput.min = '0';
            cantidadInput.value = ''; // Dejar vacío para ingresar la cantidad a sumar
            cantidadInputCell.appendChild(cantidadInput);
            row.appendChild(cantidadInputCell);

            const precioCell = document.createElement('td');
            precioCell.textContent = producto.precio_producto;
            row.appendChild(precioCell);

            const accionesCell = document.createElement('td');
            const actualizarButton = document.createElement('button');
            actualizarButton.textContent = 'Actualizar';
            actualizarButton.addEventListener('click', () => {
                const cantidadSumar = parseInt(cantidadInput.value, 10); // Obtener la cantidad a sumar

                const row = actualizarButton.closest('tr'); // Obtener la fila padre del botón "Actualizar"
                const idProducto = row.getAttribute('data-producto-id'); // Obtener el id del producto de la fila

                const request = {
                    idProducto: idProducto,
                    cantidad: cantidadSumar // Enviar la cantidad a sumar en lugar de la nueva cantidad total
                };

                fetch('/productos/cantidad', {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(request)
                })
                    .then(response => response.json())
                    .then(data => {
                        console.log(data);
                    })
                    .catch(error => console.error(error));
            });
            accionesCell.appendChild(actualizarButton);

            const eliminarButton = document.createElement('button');
            eliminarButton.textContent = 'Eliminar';
            eliminarButton.addEventListener('click', () => {
                const row = eliminarButton.closest('tr'); // Obtener la fila padre del botón "Eliminar"
                const idProducto = row.getAttribute('data-producto-id'); // Obtener el id del producto de la fila

                fetch(`/productos/${idProducto}`, {
                    method: 'DELETE'
                })
                    .then(response => {
                        if (response.ok) {
                            console.log('Producto eliminado');
                        } else {
                            console.error('Error al eliminar el producto');
                        }
                    })
                    .catch(error => console.error(error));
            });
            accionesCell.appendChild(eliminarButton);

            row.appendChild(accionesCell);

            productosTable.appendChild(row);
        });
    })
    .catch(error => console.error(error));

// Lógica para agregar productos mediante el formulario
const agregarForm = document.getElementById('agregarForm');
agregarForm.addEventListener('submit', (event) => {
    event.preventDefault();
    const nombreProducto = document.getElementById('nombreProducto').value;
    const cantidadProducto = parseInt(document.getElementById('cantidadProducto').value, 10);
    const precioProducto = parseFloat(document.getElementById('precioProducto').value);

    const nuevoProducto = {
        nombre: nombreProducto,
        cantidad: cantidadProducto,
        precio: precioProducto
    };

    fetch('/productos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(nuevoProducto)
    })
        .then(response => response.json())
        .then(data => {
            console.log(data);
            document.getElementById('nombreProducto').value = '';
            document.getElementById('cantidadProducto').value = '';
            document.getElementById('precioProducto').value = '';
        })
        .catch(error => console.error(error));
});