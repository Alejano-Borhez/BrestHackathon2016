$( document ).ready(function() {
    console.log( "ready!" );
    var model = {};

    $("#events-item").click(function() {
        $('#event-list').empty();
        $.get('/application/events', function(events) {
            model.events = {};
            var groups = [[], [], []];
            // group by 3 columns according the remainder
            // from division on 3
            events.forEach(function(val, index) {
                model.events[val.eventId] = val;
                groups[index % 3].push(val);
            });
            console.log(model.events[1]);
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
                                            'href' : '#show-event',
                                            'class' : 'btn btn-primary',
                                            'role' : 'button',
                                            'data-toggle' : 'pill',
                                            'html' : 'Show'
                                        }).click(function() {
                                            model.selectedEvent = x.eventId;
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

    $("#groups-item").click(function() {
        $('#group-list').empty();
        $.get('/application/groups', function(groups) {
            groups.map(function(x) {
                var $item = $('<div>', {
                    'class' : 'col-lg-4',
                    'html': $('<div>', {
                            'class' : 'thumbnail',
                            'style' : 'border-color: #87CEE6',
                            'html' : $('<h3>', { 'html' : x.groupName })
                                .add( $('<p>').html('<ul>').html(x.userList.map(function(a) {
                                    return $('<li>').html(a.name);
                                })) )
                    })
                });
                return $item;
            }).forEach(function(x) { $('#group-list').append(x); });
        });
    });
    
    $("#events-item").trigger('click');
    
});