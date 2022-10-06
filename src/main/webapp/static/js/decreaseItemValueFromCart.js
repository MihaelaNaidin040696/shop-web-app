const decreaseValue = () => {
    let decreasButtons = document.querySelectorAll('[data-less-id]');

    // let decreasButtons = document.querySelectorAll(".decreaseButton");

    for (let btn of decreasButtons) {
        btn.addEventListener("click", async (e) => {
            e.preventDefault();

            let productId = btn.getAttribute("data-less-id");

            const dataToBePosted = {
                id: productId,
                quantity: 1,
            };
            await fetch("/decrease-value", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(dataToBePosted)
            });
            console.log("intra");
            let input = document.getElementById(productId);
            input.value = (parseInt(input.value) - 1).toString();

            let numberOfItems = document.getElementById("numberOfItems");
            var number = parseInt(numberOfItems.innerHTML.substring(0,2));
            number= number - 1;
            numberOfItems.innerHTML = number + " products";
        });
    }
};

const init = () => {
    decreaseValue();
}

init();