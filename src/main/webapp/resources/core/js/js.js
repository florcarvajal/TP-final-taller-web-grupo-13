
/******************* ESTRELLAS *********************/

const estrellas = document.querySelectorAll('.star');
let indiceSeleccionado = -1;

estrellas.forEach((estrella, idx) => {
    estrella.addEventListener('click', () => {
        // Actualiza el índice de la última estrella seleccionada
        indiceSeleccionado = idx;

        // Elimina la selección de todas las estrellas
        estrellas.forEach(star => star.classList.remove('selected'));

        // Añade la clase 'selected' a las estrellas seleccionadas
        for (let i = 0; i <= idx; i++) {
            estrellas[i].classList.add('selected');
        }
    });

    estrella.addEventListener('mouseover', () => {
        // Elimina la selección de todas las estrellas temporalmente
        estrellas.forEach(star => star.classList.remove('selected'));

        // Añade la clase 'selected' a las estrellas sobre las cuales el mouse está
        for (let i = 0; i <= idx; i++) {
            estrellas[i].classList.add('selected');
        }
    });

    estrella.addEventListener('mouseout', () => {
        // Vuelve a aplicar la selección definitiva de las estrellas
        estrellas.forEach(star => star.classList.remove('selected'));

        // Si hay estrellas previamente seleccionadas, restaurarlas
        if (indiceSeleccionado !== -1) {
            for (let i = 0; i <= indiceSeleccionado; i++) {
                estrellas[i].classList.add('selected');
            }
        }
    });
});
/*********************** RESEÑA *******************************************/

function escribirReseña() {
    // Desplazar hacia el área de texto
    const reseña = document.getElementById('reseña');
    reseña.scrollIntoView({ behavior: 'smooth', block: 'start' });

    // Focalizar automáticamente en el área de texto
    reseña.focus();
}

/*************************************************************************/
function cambiarTexto(boton) {
    if (boton.innerHTML === "Agregar a mis libros") {
        boton.innerHTML = "Quitar de mis libros";
    } else {
        boton.innerHTML = "Agregar a mis libros";
    }
}


/*************************************************************************/
function cambiarTexto2(boton) {
    if (boton.innerHTML === "Seguir") {
        boton.innerHTML = "Dejar de seguir";
    } else {
        boton.innerHTML = "Seguir";
    }
}

/*********** CARRITO DE COMPRAS *********************************************/

    // Array para almacenar los productos en el carrito
let carrito = [];

// Función para agregar productos al carrito
function agregarAlCarrito() {
    // Obtenemos los datos dinámicos del HTML usando las clases
    const titulo = document.querySelector('.titulo').innerText;
    const autor = document.querySelector('.autor').innerText;
    const precio = parseFloat(document.querySelector('.precio').innerText.replace('$', ''));
    const portada_del_libro = document.querySelector('.portada_del_libro').src;

    // Verificar que la función se está llamando correctamente
    console.log("Agregando al carrito:", titulo, autor, precio, portada_del_libro);

    // Datos del producto
    const libro = {
        titulo: titulo,
        autor: autor,
        precio: precio,
        portada_del_libro: portada_del_libro
    };

    // Agregar el producto al array del carrito
    carrito.push(libro);

    // Actualizar el contenido del carrito en el dropdown
    actualizarCarrito();
}

// Función para actualizar el contenido del carrito en el dropdown
function actualizarCarrito() {
    const carritoDropdown = document.getElementById("carritoDropdown");

    // Limpiar el contenido anterior
    carritoDropdown.innerHTML = "";

    if (carrito.length === 0) {
        carritoDropdown.innerHTML = '<span id="carritoVacio">El carrito está vacío</span>';
    } else {
        // Agregar productos al dropdown
        carrito.forEach(function(item) {
            const nuevoItem = document.createElement("div");
            nuevoItem.innerHTML = `
                <h1 class="carrito-titulo">${item.titulo}</h1>
                <h2 class="carrito-autor">${item.autor}</h2>
                <h4 class="carrito-precio">$${item.precio.toFixed(2)}</h4>
                <img class="carrito-imagen" src="${item.portada_del_libro}" alt="Portada del libro">
                <button class="ver-carrito">Ver el carrito</button>
            `;
            carritoDropdown.appendChild(nuevoItem);
        });
    }
}

