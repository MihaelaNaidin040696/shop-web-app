const addToCart = ()=>{
    console.log("merge");
    let addToCartButtons = document.querySelectorAll(".addToCart");

    for (const element of addToCartButtons) {


        element.addEventListener("click",async ()=>{

            let productId = element.getAttribute("data-id");

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
        })
    }

}
const init=()=>{
    addToCart();
}

init();