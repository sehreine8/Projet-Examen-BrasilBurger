// Please see documentation at https://learn.microsoft.com/aspnet/core/client-side/bundling-and-minification
// for details on configuring this project to bundle and minify static web assets.

// Write your JavaScript code.
const deliveryCost = 1000;

function renderCart() {
    const panier = JSON.parse(localStorage.getItem("panier")) || [];
    let html = "";
    let subtotal = 0;

    panier.forEach((item, index) => {
        subtotal += item.prix * item.qty;

        html += `
        <div class="d-flex align-items-center mb-3">
            <img src="${item.image}" width="60" class="rounded">
            <div class="ms-3">
                <h6 class="mb-0 fw-bold">${item.nom}</h6>
                <div class="d-flex align-items-center mt-1">
                    <button class="btn btn-light btn-sm" onclick="updateQty(${index}, -1)">-</button>
                    <span class="mx-2">${item.qty}</span>
                    <button class="btn btn-light btn-sm" onclick="updateQty(${index}, 1)">+</button>
                </div>
            </div>
            <div class="ms-auto fw-bold">${(item.qty * item.prix).toLocaleString()} xof</div>
        </div>`;
    });

    document.getElementById("cart-items").innerHTML = html;
    document.getElementById("subtotal").innerText = subtotal.toLocaleString() + " xof";
    document.getElementById("total").innerText = (subtotal + deliveryCost).toLocaleString() + " xof";
}

function updateQty(index, change) {
    const panier = JSON.parse(localStorage.getItem("panier"));

    panier[index].qty += change;
    if (panier[index].qty <= 0) panier.splice(index, 1);

    localStorage.setItem("panier", JSON.stringify(panier));
    renderCart();
}

renderCart();

function addToCart(nom, prix, image) {
    const panier = JSON.parse(localStorage.getItem("panier")) || [];

    const exist = panier.find(p => p.nom === nom);

    if (exist) {
        exist.qty++;
    } else {
        panier.push({ nom, prix, image, qty: 1 });
    }

    localStorage.setItem("panier", JSON.stringify(panier));
    renderCart();
}
