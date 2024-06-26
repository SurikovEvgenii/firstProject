const csrfToken = $('meta[name="_csrf"]').attr('content');
const csrfHeader = $('meta[name="_csrf_header"]').attr('content');

// jQuery для обработки кликов по кнопке "Лайк"
$('.like-button').on('click', function(event) {
    event.preventDefault();
    const button = $(this);
    const projectId = button.data('id');

    $.ajax({
        url: '/like',
        type: 'POST',
        data: { projectId: projectId }, // Используем projectId
        beforeSend: function(xhr) {
            xhr.setRequestHeader(csrfHeader, csrfToken);
        },
        success: function(response) {
            // Обновляем количество лайков на кнопке
            button.text(`Нравится ${response}`);
        },
        error: function(xhr, status, error) {
            console.error('Ошибка при увеличении лайков:', error);
        }
    });
});