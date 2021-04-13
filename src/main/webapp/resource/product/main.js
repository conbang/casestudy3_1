function addcart(e) {
    let xhttp = new XMLHttpRequest();
    let id = e.getAttribute("data-id");
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            $(".shopping__cart-items").text(this.responseText + " items");
        }
    }
    xhttp.open("get", "/cart?action=additem&id=" + id + "&quantity=5", true);
    xhttp.send();

}

