window.onload = function () {
    renderCurrentUser();
}

function renderCurrentUser() {
    fetch('http://localhost:7000/current_user', {
        method: 'GET',
        credentials: 'include'
    }).then((response) => {
        if (response.status === 400) {
            window.location.href = '/';
        }
        return response.json();
    }).then((data) => {

        let id = data.id;
        let username = data.username;
        let password = data.password;
        let userInfoElement = document.querySelector('#user');
        userInfoElement.innerHTML = ` user logged in as: ${username}`;
    })
}

document.querySelector('#logout').addEventListener('click', logout);

function logout() {
    fetch('http://localhost:7000/logout', {
        method: 'POST'
    }).then((response) => {
        if (response.status === 200) {
            window.location.href = '/index.html';
        }
    })
}