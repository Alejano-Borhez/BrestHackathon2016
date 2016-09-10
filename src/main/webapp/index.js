$( document ).ready(function() {
    console.log( "ready!" );

    $("#events-item").click(function() {
        $('#event-list').empty();
        $.get('/application/events', function(events) {
            events.map(function(x) {
                var $item = $('<div>', {
                    'class' : 'col-lg-4',
                    'html': $('<div>', {
                        'class' : 'thumbnail',
                        'html' : $('<img>', {
                            'src': 'img/events/' + x.eventId + '.jpg'
                         }).add( $('<div>', {
                            'class' : 'caption',
                            'html' : $('<h3>', { 'html' : x.eventName })
                                .add( $('<p>').html(x.eventDescription) )
                                .add(  $('<p>', {
                                    'html' : $('<a>', {
                                        'href' : '#',
                                        'class' : 'btn btn-primary',
                                        'role' : 'button',
                                        'html' : 'Show'
                                    })
                                }))
                         }))
                    })
                });
                return $item;
            }).forEach(function(x) { $('#event-list').append(x); });
        });
    });

    $("#groups-item").click(function() {
        $('#group-list').empty();
        $.get('/application/groups', function(groups) {
            groups.map(function(x) {
                var $item = $('<div>', {
                    'class' : 'col-lg-4',
                    'html': $('<div>', {
                            'class' : 'caption',
                            'html' : $('<h3>', { 'html' : x.groupId })
                                .add( $('<p>').html(x.userList) )
                    })
                });
                return $item;
            }).forEach(function(x) { $('#group-list').append(x); });
        });
    });
    
    $("#events-item").trigger('click');

    $("#groups-item").trigger('click');
});