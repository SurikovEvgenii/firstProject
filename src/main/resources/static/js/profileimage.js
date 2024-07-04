const fileInput = document.getElementById('photo');

fileInput.addEventListener('change', event => {
    const maxAllowedFiles = 1;

    const files = Array.from(fileInput.files).slice(
        0,
        maxAllowedFiles,
    );
    console.log(files);

    // Your code for uploading the file to the remote server (e.g. AWS S3)
});