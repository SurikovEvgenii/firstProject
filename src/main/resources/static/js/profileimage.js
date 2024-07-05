const fileInput = document.getElementById('photo');

fileInput.addEventListener('change', event => {
    const maxAllowedFiles = 1;

    const files = Array.from(fileInput.files).slice(
        0,
        maxAllowedFiles,
    );
    console.log(files);

});

document.getElementById("photo").onchange = function() {
    document.getElementById("form").submit();
};