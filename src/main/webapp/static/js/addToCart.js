const addToCart = () => {
    let addToCartButtons = document.querySelectorAll(".addToCart");

    for (const element of addToCartButtons) {
        element.addEventListener("click", async () => {

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
};
//
// const addMore = () => {
//
//     let addMoreButtons = document.querySelectorAll('[data-more-id]');
//
//     for (let btn of addMoreButtons) {
//         btn.addEventListener("click", async (e) => {
//             e.preventDefault();
//
//             let productId = btn.getAttribute("data-more-id");
//
//             const dataToBePosted = {
//                 id: productId,
//                 quantity: 1,
//             };
//             await fetch("/add-to-cart", {
//                 method: 'POST',
//                 headers: {
//                     'Content-Type': 'application/json'
//                 },
//                 body: JSON.stringify(dataToBePosted)
//             });
//
//             let input = document.getElementById('2');
//         });
//     }
// };

const init = () => {
    addToCart();
    // addMore();
}

init();