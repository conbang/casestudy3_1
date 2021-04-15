let cost = 0;
let wallet = 0;
let listprotduct = [];

function getItemCost() {
    for (i = 0; i < $("input[type='number']").length; i++) {
        listprotduct[i] = {
            id: $("input[type=checkbox]:eq(" + i + ")").attr("data-id"),
            amount: $("input[type=number]:eq(" + i + ")").val() * $("input[type=checkbox]:eq(" + i + ")").attr("data-price")
        }
    }
    wallet = $("#overbalance").text()
    console.log(wallet)
}

function addcart(e) {
    let productId = e.getAttribute("data-id")
    additem(productId, 1)
}

function decrItem(e) {
    e.parentNode.querySelector('input[type=number]').stepDown()
    let amount = e.parentNode.querySelector('input[type=number]').value
    let productId = $(e.parentNode).attr("data-id")
    let price = $(e.parentNode).attr("data-price")
    $("strong[class=" + productId + "]").text(amount * price + " d")
    updateData(productId, amount)
    for (i = 0; i < listprotduct.length; i++) {
        if (listprotduct[i].id == productId) {
            listprotduct[i].amount = amount * price;
            return
        }
    }
}

function chooseItem(e) {
    let productId = $(e).attr('data-id')
    if ($(e).prop('checked')) {
        for (i = 0; i < listprotduct.length; i++) {
            if (listprotduct[i].id == productId) {
                cost += listprotduct[i].amount
            }
        }
    } else {
        for (i = 0; i < listprotduct.length; i++) {
            if (listprotduct[i].id == productId) {
                cost -= listprotduct[i].amount
            }
        }
    }
    $("#cost").text(cost);
    $("#overbalance").text(wallet - cost)
    if (wallet - cost >= 0 && cost != 0 ) {
        $(".checkout").prop('disabled', false);
    } else {
        $(".checkout").prop('disabled', true);
    }
}

function addItems(e) {
    e.parentNode.querySelector('input[type=number]').stepUp()
    let amount = e.parentNode.querySelector('input[type=number]').value
    let productId = $(e.parentNode).attr("data-id")
    let price = $(e.parentNode).attr("data-price")
    $("strong[class=" + productId + "]").text(amount * price + " d")
    updateData(productId, amount)
    for (i = 0; i < listprotduct.length; i++) {
        if (listprotduct[i].id == productId) {
            listprotduct[i].amount = amount * price;
            return
        }
    }
}

function additem(productId, amount) {
    let myObj = {action: "additem", id: productId, quantity: amount};
    let myJson = JSON.stringify(myObj)
    $.ajax({
        url: '/cart',
        type: 'post',
        dataType: 'application/json',
        data: myJson
    }).done(function (resp) {
        $('.shopping__cart-items').html(resp + " items")
    })

}

function updateData(productId, amount) {
    let myObj = {action: "updateQuantity", id: productId, quantity: amount};
    let myJson = JSON.stringify(myObj)
    $.ajax({
        url: '/cart',
        type: 'post',
        dataType: 'application/json',
        data: myJson
    }).done(function (resp) {
            $('.shopping__cart-items').html(resp + " items")
        }
    )
}

function remove(e) {
    let productId = $(e).attr("data-id")
    $("#" + productId).remove()
    updateData(productId, 0)
}

function payment() {
    let myObj = [];
    for (i = 0; i < listprotduct.length; i++) {
        if ($("input[type=checkbox]:eq(" + i + ")").prop('checked')) {
            myObj[myObj.length] = $("input[type=checkbox]:eq(" + i + ")").attr('data-id')
        }
    }
    let myJson = JSON.stringify({id:myObj})
    $.ajax({
        url: '/payment',
        type: 'post',
        dataType: 'application/json',
        data: myJson
    }).done(function (resp) {

    })
}

