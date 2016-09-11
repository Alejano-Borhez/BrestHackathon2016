$( document ).ready(function() {
    console.log( "ready!" );
    var model = {};

    function expectedBudget() {
        var maximum = model.budget || 0;
        var expected = 0;
        (model.selectedGroups || []).forEach(function(groupId) {
            var memberCount = model.groups[groupId].userList.length;
            (model.selectedActions || []).forEach(function(actionId) {
                var cost = model.actions[actionId].costPerUser;
                expected += (cost * memberCount);
            });
        });
        var remain = maximum - expected;
        if (remain >= 0) {
            $('#remain-amount')
                .html('Remain: ' + remain + ' BYN')
                .css('color', 'green');
            $('#add-event-button').removeAttr('disabled');
        } else {
            $('#remain-amount')
                .html('Over-limit: ' + -remain + ' BYN')
                .css('color', 'red');
            $('#add-event-button').attr('disabled', 'disabled');
        }
    }

    $('#budget').change(function() {
        model.budget = $(this).val();
        expectedBudget();
    });

    $('#groupList').change(function() {
        model.selectedGroups = $(this).val();
        expectedBudget();
    });

    $('#actionList').change(function() {
        model.selectedActions = $(this).val();
        expectedBudget();
    });

    $("#add-event-btn").click(function() {
        $('#groupList').empty();
        $.get('/application/groups', function(groups) {
            model.groups = {};
            groups.forEach(function(group) {
                model.groups[group.groupId] = group;
                $('#groupList').append( $('<option>', {
                    'value' : group.groupId,
                    'html' : group.groupName + " (" + group.userList.length + " members)"
                }) );
            })
        });
        $('#actionList').empty();
        $.get('/application/actions', function(actions) {
            model.actions = {};
            var ratings = actions.map(function(a) { return a.actionRating; });
            var avg = ratings.reduce(function(x, y){ return x + y; })/ratings.length;
            actions.forEach(function(action) {
                model.actions[action.actionId] = action;
                var color = 'bg-info';
                if (action.actionRating < avg/2) color = 'bg-danger';
                else if (action.actionRating < avg) color = 'bg-warning';
                else if (action.actionRating < avg * 1.5) color = 'bg-success';
                $('#actionList').append( $('<option>', {
                    'value' : action.actionId,
                    'class' : color,
                    'html' : action.actionName + " (" + action.costPerUser + " BYN per person)"
                }) );
            })
        });
    });

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
                                            return $('<li>').html(a.actionName);
                                       })
                                    })).add( $('<p>', {
                                            'html' : $('<a>', {
                                            'href' : '#show-event',
                                            'class' : 'btn btn-primary',
                                            'role' : 'button',
                                            'data-toggle' : 'pill',
                                            'html' : 'Show'
                                        }).click(function() {
                                            $("#event-image")
                                                .attr('src', 'img/events/' + x.eventId + '.jpg');
                                            $("#event-name").html(x.eventName);
                                            $("#event-description").html(x.eventDescription);
                                            $("#event-groups").empty();
                                            var userCount = 0;
                                            x.groups.forEach(function(group) {
                                                userCount += group.userList.length;
                                                var $span = $('<span>', {
                                                    'class' : 'badge',
                                                    'html': group.userList.length
                                                });
                                                var $li = $('<li>', {
                                                    'class' : 'list-group-item',
                                                    'html' : group.groupName
                                                });
                                                $("#event-groups").append( $li.append($span) );
                                            });
                                            var expectedBudget = 0;
                                            $("#event-actions").empty();
                                            x.actions.forEach(function(action, index) {
                                                var total = action.costPerUser * userCount;
                                                expectedBudget += total;
                                                var $row = $('<tr>', {
                                                    'html' : $('<td>').html(index)
                                                        .add($('<td>').html(action.actionName))
                                                        .add($('<td>').html(action.costPerUser))
                                                        .add($('<td>').html(total))
                                                });
                                                $("#event-actions").append($row);
                                            });
                                            $('#maximum-budget').html("Maximum budget: <strong>"
                                                + x.budget + "</strong>");
                                            $('#expected-budget').html("Expected budget: <strong>"
                                                + expectedBudget + "</strong>");
                                            $('#event-date').html("Date: <strong>"
                                                + new Date(x.eventDate).toDateString() + "</strong>");
                                            $('#event-location').html("Location: <strong>"
                                                + x.location + "</strong>");
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
            var columns = [[],[]];
            events.forEach(function(val, index) {
                columns[index % 2].push(val);
            });
            columns.forEach(function(column) {
                var $col = $('<div>', { 'class' : 'col-lg-6' });
                column.map(function(x) {
                    var $item = $('<div>', {
                        'class' : 'media',
                        'style' : 'padding-left:20px',
                        'html' : $('<div>', {
                            'class' : "media-left",
                            'html' : $('<img>', {
                                'class' : 'media-object',
                                'width' : '200px',
                                'height' : '200px',
                                'src' : 'img/actions/' + x.actionId + '.jpg'
                            })
                        }).add( $('<div>', {
                            'class' : "media-body",
                            'html' : $('<h3>')
                                .html(x.actionName)
                                .add( $('<p>').html(x.actionDescription) )
                                .add( $('<p>').html('Cost per person: ' + x.costPerUser + ' BYN') )
                                .add( $('<p>').html('Rating: ' + x.actionRating) )
                        }))
                    });
                    return $item;
                }).forEach(function(x) { $col.append(x); });
                $('#action-list').append($col);
            });
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
                            .add( $('<p>', {'html' : $('<ul>').add(x.userList.map(function(a) {
                                return $('<li>').html(a.name).html('<p>').html(a.favourite.map(
                                    function (f) {
                                        return $('<span>').addClass('label label-default').html(f.actionName);
                                    }
                                ));
                            })) }))
                    })
                });
                return $item;
            }).forEach(function(x) { $('#group-list').append(x); });
        });
    });
    
    $("#events-item").trigger('click');
    
});