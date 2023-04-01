document.querySelector('#login').addEventListener('click', () => {
    let modal1 = document.querySelector('#modal1');
    modal1.classList.add('active');

    document.querySelector('#login-close').addEventListener('click', () =>{
        let modal1 = document.querySelector('#modal1');
        modal1.classList.remove('active');
    });
});


document.querySelector('#signup').addEventListener('click', () => {
    let modal2 = document.querySelector('#modal2');
    modal2.classList.add('active');

    document.querySelector('#signin-close').addEventListener('click', () =>{
        let modal2 = document.querySelector('#modal2');
        modal2.classList.remove('active');
    });
});