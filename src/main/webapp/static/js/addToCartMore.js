const addMore = () => {
    let addMoreButtons = document.querySelectorAll('[data-more-id]');

    for (let btn of addMoreButtons) {
        btn.addEventListener("click", async (e) => {
            e.preventDefault();

            let productId = btn.getAttribute("data-more-id");

            const dataToBePosted = {
                id: productId,
                quantity: 1,
            };
            await fetch("/add-to-cart", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(dataToBePosted)
            });
            let input = document.getElementById(productId);
            input.value = (parseInt(input.value) + 1).toString();

            let numberOfItems = document.getElementById("numberOfItems");
            let number = parseInt(numberOfItems.innerHTML.substring(0, 2));
            number = number + 1;
            numberOfItems.innerHTML = number + " products";
            totals();
            totalItem();
        });
    }
};

const totals = () => {
    let allDivs = document.querySelectorAll(".deleteWhen0");
    let totalSum = 0
    let total = document.querySelector("#total");
    for (const allDiv of allDivs) {
        totalSum += (parseFloat(allDiv.children[1].children[1].value) * parseFloat(allDiv.children[2].children[0].innerHTML.substring(0, allDiv.children[2].children[0].innerHTML.indexOf(' '))));
    }
    total.innerHTML = totalSum + " EUR";
}

const totalItem = () => {
    let allDivs = document.querySelectorAll(".deleteWhen0");
    for (const allDiv of allDivs) {
        let totalProdPrice = allDiv.children[2].children[1];
        let unit = allDiv.children[1].children[1].value;

        totalProdPrice.innerHTML = unit * parseFloat(allDiv.children[2].children[0].innerHTML.substring(0, allDiv.children[2].children[0].innerHTML.indexOf(' '))) + " EUR";
    }
}

const init = () => {
    addMore();
    totals();
    totalItem();
}

init();