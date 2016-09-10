$( document ).ready(function() {
    console.log( "ready!" );
    $("#events-item").click(function() {
        $('#event-list').empty();
        var events = [
            {
                eventId: 1,
                eventName: 'Event',
                eventDescription: "In the Gregorian calendar, New Year's Eve (also known as Old Year's Day or Saint Sylvester's Day in many countries), the last day of the year, is on December 31. In many countries, New Year's Eve is celebrated at evening social gatherings, where many people dance, eat, drink alcoholic beverages, and watch or light fireworks to mark the new year. Some people attend a watch night service. The celebrations generally go on past midnight into January 1 (New Year's Day)."
            },
            {
                eventId: 1,
                eventName: 'Event',
                eventDescription: "In the Gregorian calendar, New Year's Eve (also known as Old Year's Day or Saint Sylvester's Day in many countries), the last day of the year, is on December 31. In many countries, New Year's Eve is celebrated at evening social gatherings, where many people dance, eat, drink alcoholic beverages, and watch or light fireworks to mark the new year. Some people attend a watch night service. The celebrations generally go on past midnight into January 1 (New Year's Day)."
            },
            {
                eventId: 1,
                eventName: 'Event',
                eventDescription: "In the Gregorian calendar, New Year's Eve (also known as Old Year's Day or Saint Sylvester's Day in many countries), the last day of the year, is on December 31. In many countries, New Year's Eve is celebrated at evening social gatherings, where many people dance, eat, drink alcoholic beverages, and watch or light fireworks to mark the new year. Some people attend a watch night service. The celebrations generally go on past midnight into January 1 (New Year's Day)."
            },
            {
                eventId: 1,
                eventName: 'Event',
                eventDescription: "In the Gregorian calendar, New Year's Eve (also known as Old Year's Day or Saint Sylvester's Day in many countries), the last day of the year, is on December 31. In many countries, New Year's Eve is celebrated at evening social gatherings, where many people dance, eat, drink alcoholic beverages, and watch or light fireworks to mark the new year. Some people attend a watch night service. The celebrations generally go on past midnight into January 1 (New Year's Day)."
            },
            {
                eventId: 1,
                eventName: 'Event',
                eventDescription: "In the Gregorian calendar, New Year's Eve (also known as Old Year's Day or Saint Sylvester's Day in many countries), the last day of the year, is on December 31. In many countries, New Year's Eve is celebrated at evening social gatherings, where many people dance, eat, drink alcoholic beverages, and watch or light fireworks to mark the new year. Some people attend a watch night service. The celebrations generally go on past midnight into January 1 (New Year's Day)."
            },
            {
                eventId: 1,
                eventName: 'Event',
                eventDescription: "In the Gregorian calendar, New Year's Eve (also known as Old Year's Day or Saint Sylvester's Day in many countries), the last day of the year, is on December 31. In many countries, New Year's Eve is celebrated at evening social gatherings, where many people dance, eat, drink alcoholic beverages, and watch or light fireworks to mark the new year. Some people attend a watch night service. The celebrations generally go on past midnight into January 1 (New Year's Day)."
            }
        ];
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
    $("#events-item").trigger('click');
});