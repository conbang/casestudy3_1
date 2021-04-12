function addcart() {
    let xhttp = new XMLHttpRequest();
    let id = $(".item").attr("data-id");
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {

        }
    }
    xhttp.open("get", "/cart?action=add&id="+id,true);
    xhttp.send();

}