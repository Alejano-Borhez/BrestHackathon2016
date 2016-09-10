$( document ).ready(function() {

    $("#events-item").click(function() {
        $('#event-list').empty();
        $.get('/application/events', function(events) {
            var groups = [[], [], []];
            // group by 3 columns according the remainder
            // from division on 3
            events.forEach(function(val, index) {
                groups[index % 3].push(val);
            });
            groups.forEach(function(group) {
                var $item = $('<div>', {
                    'class' : 'col-lg-4',
                    'html': group.map(function(x) {
                        return $('<div>', {
                            'class' : 'thumbnail',
                            'html' : $('<img>', {
                                    'src': 'img/events/' + x.eventId + '.jpg',
                                    'width' : '100%'
                             }).add( $('<div>', {
                                    'class' : 'caption',
                                    'html' : $('<h3>', { 'html' : x.eventName })
                                       .add( $('<p>').html(x.eventDescription) )
                                       .add( $('<ul>', {
                                            'html': x.actions.map(function(a) {
                                            return $('<li>').html(a.type);
                                       })
                                    })).add( $('<p>', {
                                            'html' : $('<a>', {
                                            'href' : '#',
                                            'class' : 'btn btn-primary',
                                            'role' : 'button',
                                            'html' : 'Show'
                                        })
                                    }))
                             }))
                        });
                    })
                });
                $('#event-list').append($item)
            });
        });
    });
    $("#actions-item").click(function() {
        $('#action-list').empty();
        $.get('/application/actions', function(events) {
            events.map(function(x) {
                var $item = $('<div>', {
                    'class' : 'media',
                    'html' : $('<div>', {
                        'class' : "media-left",
                        'html' : $('<img>', {
                            'class' : 'media-object',
                            'width' : '100px',
                            'height' : '100px',
                            'src' : 'img/actions/' + x.actionId + '.jpg'
                        })
                    }).add( $('<div>', {
                        'class' : "media-body",
                        'html' : $('<h4>')
                            .html("(" + x.type + ") " + x.actionDescription)
                    }))
                });
                return $item;
            }).forEach(function(x) { $('#action-list').append(x); });
        });
    });
    $("#events-item").trigger('click');
});