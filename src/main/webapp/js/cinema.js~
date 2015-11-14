// AJAX Login

$("#login-form").submit(function(event) {
    event.preventDefault();
    $("#login-button").attr("disabled","disabled");
    $("#login-button").html("<i class=\"zmdi zmdi-rotate-left zmdi-hc-spin-reverse\"></i> Accesso");
    $.ajax({
        type: "POST",
        url: "check-login",
        data: "username=" + $("#input-email").val() + "&password=" + $("#input-password").val(),
        success: function(answer) {
            answer = answer.trim();
            if(answer == "success") {
                $("#login-modal").modal("hide");
                $("#menu").html("<i class=\"zmdi zmdi-rotate-left zmdi-hc-spin-reverse\"></i> Caricamento...");
                $.get("jsp/menu.jsp", function(data) {
                    $("#menu").html(data);
                });
            } else {
                $("#login-button").html("Accedi");
                $("#login-button").removeAttr("disabled");
                $("#login-modal").effect("shake");
            }
        }
    });
});


// AJAX SignUp

$("#signup-form").submit(function(event) {
    event.preventDefault();
    $("#signup-existing").slideUp("fast");
    $("#signup-wrong-password").slideUp("fast");
    $("#signup-error").slideUp("fast");
    $("#signup-success").slideUp("fast");
    $("#signup-button").attr("disabled", "disabled");
    $("#signup-button").html("<i class=\"zmdi zmdi-rotate-left zmdi-hc-spin-reverse\"></i> Attendere");
    $.ajax({
        type: "POST",
        url: "signUp",
        data: "email=" + $("#signup-email").val() + "&password1=" + $("#signup-password1").val() + "&password2=" + $("#signup-password2").val(),
        success: function(answer) {
            answer = answer.trim();
            if(answer == "success") {
                $("#signup-button").hide();
                $("#signup-success").slideDown("slow");
            } else if (answer == "existing") {
                $("#signup-existing").slideDown("slow");
                $("#signup-button").html("Registrati");
                $("#signup-button").removeAttr("disabled");
            } else if (answer == "wrong-password") {
                $("#signup-wrong-password").slideDown("slow");
                $("#signup-button").html("Registrati");
                $("#signup-button").removeAttr("disabled");
            } else {
                $("#signup-error").slideDown("slow");
                $("#signup-button").html("Registrati");
                $("#signup-button").removeAttr("disabled");
            }
        }
    });
});


// Password Recovery

$("#recovery-form").submit(function(event) {
    event.preventDefault();
    $("#recovery-sent").slideUp("fast");
    $("#recovery-no-email").slideUp("fast");
    $("#recovery-error").slideUp("fast");
    $("#recovery-button").attr("disabled", "disabled");
    $("#recovery-button").html("<i class=\"zmdi zmdi-rotate-left zmdi-hc-spin-reverse\"></i> Attendere");
    $.ajax({
        type: "POST",
        url: "recuperaPassword",
        data: "email=" + $("#recovery-email").val(),
        success: function(answer) {
            answer = answer.trim();
            if (answer == "success") {
                $("#recovery-sent").slideDown("slow");
                $("#recovery-button").hide();
                $("#recovery-cancel").text("Chiudi");
            } else if (answer == "noemail") {
                $("#recovery-no-email").slideDown("slow");
                $("#recovery-button").removeAttr("disabled");
                $("#recovery-button").html("Recupera");
            } else {
                $("#recovery-error").slideDown("slow");
                $("#recovery-button").removeAttr("disabled");
                $("#recovery-button").html("Recupera");
            }
        }
    });
});


// Prenotazione


var seats = new Array();
var seconds = 1;
var totale;
function updatePosti (spettacolo) {
    var currentSeats = new Array();
    var oldSeats = new Array();
    var interval = 1000;
    setInterval(function () {
        $.getJSON("statoPrenotazioni", "spettacolo=" + spettacolo, function (result) {
            // Parsing dell'oggeto JSON
            $.each(result, function (key1, val1) {
                var idPosto, timestamp, stato, prezzo, x, y;
                idPosto = key1;
                $.each(val1, function (key2, val2) {
                    if (key2 == "timestamp") {
                        timestamp = parseInt(val2);
                    } else if (key2 == "stato") {
                        stato = val2;
                    } else if (key2 == "prezzo") {
                        prezzo = parseInt(val2);
                    } else if (key2 == "y") {
                        y = val2.toUpperCase();
                    } else if (key2 == "x") {
                        x = val2;
                        if (parseInt(x) < 10) {
                            x = "0" + x;
                        }
                    }
                });
                var currentObject = {"idPosto": idPosto, "timestamp": timestamp, "stato": stato, "prezzo": prezzo, "y": y, "x": x};
                seats.push(currentObject);
                currentSeats.push(currentObject.idPosto);
            });
            // Reset
            $(".posto").each(function (index, element) {
                $(element).removeClass("tuo");
                $(element).removeClass("tuo-tmp");
                $(element).removeClass("occupato");
                $(element).removeClass("occupato-tmp");
            });
            $("#posti-selezionati-list").html("");
            totale = 0.;
            // Fill
            $.each(seats, function (index, object) {
                $("#posto-" + object.idPosto).addClass(object.stato);
                if (object.stato == "tuo-tmp") {
                    totale += parseFloat(prezzi[object.prezzo][1].replace(",", ".").substring(7));
                    var percentuale = (object.timestamp / 300) * 100;
                    var m = Math.floor(object.timestamp / 60);
                    var s = object.timestamp % 60;
                    var mm = "0" + m;
                    var ss;
                    if (s < 10) {
                        ss = "0" + s;
                    } else {
                        ss = s;
                    }
                    var remaining = mm + ":" + ss;
                    $("#payment-timer").text(remaining);
                    if (object.timestamp == 1) {
                        $("#no-selected").hide();
                        $("#posti-selezionati-list").append("<div class=\"prenotazione-container\" id=\"prenotazione-" + object.idPosto + "\"><div class=\"progress-bar-light\"><div class=\"progress-bar-dark\" style=\"width:" + percentuale + "%;\"></div></div><div class=\"selezionato-container\"><div class=\"posto-side tuo-tmp\">" + object.y + object.x + "</div><strong>" + prezzi[object.prezzo][1] + "</strong> " + prezzi[object.prezzo][0] + "<div class=\"delete-posto\"><i class=\"zmdi zmdi-timer\"></i> " + remaining + " <button href=\"#\" class=\"delete-posto\" id=\"delete-" + object.idPosto + "\"><i class=\"zmdi zmdi-close\"></i></button></div></div></div>");
                        setTimeout(function () {
                            $("#prenotazione-" + object.idPosto).slideUp(200);
                            if (seats.length == 1) {
                                $("#no-selected").slideDown(200);
                                $("#totale-bottone").slideUp(200);
                            }
                            $("#pagamento-modal").modal("hide");
                        }, 750);
                    } else {
                        if ($.inArray(object.idPosto, currentSeats) > -1 && $.inArray(object.idPosto, oldSeats) == -1) {
                            $("#posti-selezionati-list").append("<div class=\"prenotazione-container\" id=\"prenotazione-" + object.idPosto + "\" style=\"display: none;\"><div class=\"progress-bar-light\"><div class=\"progress-bar-dark\" style=\"width:" + percentuale + "%;\"></div></div><div class=\"selezionato-container\"><div class=\"posto-side tuo-tmp\">" + object.y + object.x + "</div><strong>" + prezzi[object.prezzo][1] + "</strong> " + prezzi[object.prezzo][0] + "<div class=\"delete-posto\"><i class=\"zmdi zmdi-timer\"></i> " + remaining + " <button href=\"#\" class=\"delete-posto\" id=\"delete-" + object.idPosto + "\"><i class=\"zmdi zmdi-close\"></i></button></div></div></div>");
                            $("#prenotazione-" + object.idPosto).slideDown(300);
                            if (seats.length == 1 || seconds < 3) {
                                $("#no-selected").slideUp(300);
                                $("#totale-bottone").slideDown(300);
                            }
                        } else {
                            $("#posti-selezionati-list").append("<div class=\"prenotazione-container\" id=\"prenotazione-" + object.idPosto + "\"><div class=\"progress-bar-light\"><div class=\"progress-bar-dark\" style=\"width:" + percentuale + "%;\"></div></div><div class=\"selezionato-container\"><div class=\"posto-side tuo-tmp\">" + object.y + object.x + "</div><strong>" + prezzi[object.prezzo][1] + "</strong> " + prezzi[object.prezzo][0] + "<div class=\"delete-posto\"><i class=\"zmdi zmdi-timer\"></i> " + remaining + " <button class=\"delete-posto\" id=\"delete-" + object.idPosto + "\"><i class=\"zmdi zmdi-close\"></i></button></div></div></div>");
                            $("#no-selected").hide();
                            $("#totale-bottone").show();
                        }
                    }
                }
            });
            $("#totale").html("&euro; " + totale.toFixed(2));
            $("#totale-modal").html("&euro; " + totale.toFixed(2));
            interval = 1000;
        }).fail( function(d, textStatus, error) {
            interval = 5000;
        });
        oldSeats = currentSeats.slice();
        currentSeats.splice(0,currentSeats.length);
        seats.splice(0,seats.length);
        seconds++;
    }, interval);
}

// db-fail: errore nel database, probabile posto doppio

$(".posto").click(function (event) {
    var posto = event.target;
    var postoString = $.trim($(posto).text());
    var postoId = $(posto).attr("id").substring(6);
    if (!$(posto).hasClass("occupato") && !$(posto).hasClass("occupato-tmp") && !$(posto).hasClass("tuo-tmp")) {
        $("#prenotazione-posto-id").val(postoId);
        $("#posto-id").text(postoString);
        $("#posto-id-2").val(postoString);
        $("#prenotazione-modal").modal();
    }
});

$(document).on("click", ".delete-posto", function (event) {
    var idPosto;
    try {
        idPosto = $(event.target).attr("id").substring(7);
    } catch (e) {
        idPosto = $(event.target).parent().attr("id").substring(7);
    }
    $.ajax({
        url: "DeletePrenotazioneTmp",
        data: "posto=" + idPosto + "&spettacolo=" + id_spettacolo,
        success: function (result) {
            $("#prenotazione-" + idPosto).slideUp(100);
            if (seats.length == 1) {
                $("#no-selected").slideDown(100);
                $("#totale-bottone").slideUp(100);
            }
        }
    });
});

$("#prenota-form").submit(function (event) {
    $("#prenotazione-error").slideUp("fast");
    $("#conferma-prenotazione-button").attr("disabled", "disabled");
    $("#conferma-prenotazione-button").html("<i class=\"zmdi zmdi-rotate-right zmdi-hc-spin\"></i> Caricamento...");
    event.preventDefault();
    var tipo = $("#prenotazione-tipo").val();
    var postoId = $("#prenotazione-posto-id").val();
    $.ajax({
        type: "GET",
        url: "aggiungiPrenotazioneTmp",
        data: "spettacolo=" + id_spettacolo + "&idPosto=" + postoId + "&prezzo=" + tipo,
        success: function(answer) {
            answer = $.trim(answer);
            if (answer == "success") {
                $("#prenotazione-modal").modal("hide");
                $("#conferma-prenotazione-button").removeAttr("disabled");
                $("#conferma-prenotazione-button").html("Conferma Prenotazione");
            } else {
                $("#prenotazione-error").slideDown("slow");
                $("#conferma-prenotazione-button").removeAttr("disabled");
                $("#conferma-prenotazione-button").html("Conferma Prenotazione");
            }
        }
    });
});

$("#procedi-button").click(function () {
    $.ajax({
        url: "IsLogged",
        success: function(answer) {
            answer = $.trim(answer);
            if (answer == "true") {
                $.ajax({
                    url: "getCredito",
                    success: function (creditoString) {
                        var credito = parseFloat(creditoString);
                        var addebito = totale - credito;
                        if (addebito <= 0.) {
                            addebito = 0.;
                            $("#paga-next").hide();
                            $("#paga-button").show();
                            $("#paga-button").text("Conferma");
                        }else{
                            var i;
                            for(i=0; i<document.getElementsByClassName("req").length; i++)
                                document.getElementsByClassName("req")[i].setAttribute("required","");
                        }
                        $.ajax({
                            url: "synchronizeTimers",
                            data: "spettacolo=" + id_spettacolo,
                            success: function (result) {
                                $("#credito-modal").html("&euro; " + credito.toFixed(2));
                                $("#addebito-modal").html("&euro; " + addebito.toFixed(2));
                                $("#pagamento-modal").modal();
                            }
                        });
                    }
                });
                
            } else {
                $("#login-modal").modal();
            }
        }
    });
});

$("#paga-next").click(function () {
    $("#paga-next").hide();
    $("#paga-button").show();
    $("#riepilogo").slideUp(300);
    $("#form-carta").slideDown(300);
    $("#paga-button").text("Conferma Pagamento");
});


// Link che mostra descrizione completa

$('a.mostranascondi').click(function(){
    var id = this.id.substring(1);
    var prefix = this.id.substring(0,1);
    if(prefix === 'm'){
        $('#'+this.id).hide();
        $('#dm'+id).hide();
        $('#div'+id).show();
    }else{
        $('#div'+id).hide();
        $('#m' + id).show();
        $('#dm'+id).show();
    }                
});


// Admin

$(".posto-admin").click(function (event) {
    var posto = event.target;
    var postoString = $.trim($(posto).text());
    var postoId = $(posto).attr("id").substring(6);
    $("#cambia-stato-posto-id").val(postoId);
    $("#posto-id").text(postoString);
    $("#posto-id-2").val(postoString);
    $("#cambia-stato-modal").modal();
});


$("#cerca-spettacoli").submit(function (event) {
    event.preventDefault();
    $('#spettacoli').html("");
    var titolo = $("#titolo").val();
    var genere = $("#genere").val();
    var regista = $("#regista").val();
    var sala = $("#sala").val();
    var durataMin = $("#durataMin").val();
    var durataMax = $("#durataMax").val();
    var programmazioneDa = $("#programmazioneDa").val();
    var programmazioneA = $("#programmazioneA").val();
    $.getJSON("../AdminGetSpettacoli", "titolo=" + titolo + "&genere=" + genere + "&regista=" + regista + "&sala=" + sala + "&durataMin=" + durataMin + "&durataMax=" + durataMax + "&programmazioneDa=" + programmazioneDa + "&programmazioneA=" + programmazioneA, function (result) {
        $.each(result, function (key, val) {
            var idFilm, titolo, regista, genere, anno, durata, data, ora, sala, idSpettacolo;
            idSpettacolo = key;
            $.each(val, function (key2, val2) {
                if(key2 == "idFilm")
                    idFilm = val2;
                else if(key2 == "titolo")
                    titolo = val2;
                else if(key2 == "regista")
                    regista = val2;
                else if(key2 == "genere")
                    genere = val2;
                else if(key2 == "anno")
                    anno = val2;
                else if(key2 == "durata")
                    durata = val2;
                else if(key2 == "data")
                    data = val2;
                else if(key2 == "ora")
                    ora = val2;
                else if(key2 == "sala")
                    sala = val2;
            });            
            $('#spettacoli').append("\n\
        <tr>\n\
            <td><a class=\"no-color\" href=\"../dettaglio-film.html?idfilm=" + idFilm + "\">" + titolo + "</a> <small class=\"text-muted hidden-xs\">" + regista + " &middot; " + anno + " &middot; " + genere + " &middot; " + durata + "min</small></td>\n\
            <td class=\"text-center\">" + data + "</td>\n\
            <td class=\"text-center\">" + ora + "</td>\n\
            <td class=\"text-center\">" + sala + "</td>\n\
            <td class=\"text-center\"><a class=\"no-color\" href=\"spettacoli.html?idspettacolo=" + idSpettacolo + "\"><i class=\"zmdi zmdi-calendar-check\"></i></a></td>\n\
        </tr>\n\
                ");
        });
    });
});

$("#cerca-prenotazioni").submit(function (event) {
    event.preventDefault();
    $('#prenotazioni').html("");
    var titolo = $("#titolo").val();
    var genere = $("#genere").val();
    var regista = $("#regista").val();
    var sala = $("#sala").val();
    var durataMin = $("#durataMin").val();
    var durataMax = $("#durataMax").val();
    var programmazioneDa = $("#programmazioneDa").val();
    var programmazioneA = $("#programmazioneA").val();
    var email = $("#email").val();
    var ruolo = $("#ruolo").val();
    var prenotazioneDa = $("#prenotazioneDa").val();
    var prenotazioneA = $("#prenotazioneA").val();
    var tipoPrezzo = $("#tipoPrezzo").val();
    var riga = $("#riga").val();
    var colonna = $("#colonna").val();    
    $.getJSON("../AdminGetPrenotazioni", "titolo=" + titolo + "&genere=" + genere + "&regista=" + regista + "&sala=" + sala + "&durataMin=" + durataMin + "&durataMax=" + durataMax + "&programmazioneDa=" + programmazioneDa + "&programmazioneA=" + programmazioneA + "&email=" + email + "&ruolo=" + ruolo + "&prenotazioneDa=" + prenotazioneDa + "&prenotazioneA=" + prenotazioneA + "&tipoPrezzo=" + tipoPrezzo + "&riga=" + riga + "&colonna=" + colonna, function (result) {
        $.each(result, function (key, val) {
            var idFilm, titolo, regista, genere, anno, durata, dataSpettacolo, dataPrenotazione, sala, utente, biglietto, posto, idPrenotazione;
            idPrenotazione = key;
            $.each(val, function (key2, val2) {
                if(key2 == "idFilm")
                    idFilm = val2;
                else if(key2 == "titolo")
                    titolo = val2;
                else if(key2 == "regista")
                    regista = val2;
                else if(key2 == "genere")
                    genere = val2;
                else if(key2 == "anno")
                    anno = val2;
                else if(key2 == "durata")
                    durata = val2;
                else if(key2 == "dataSpettacolo")
                    dataSpettacolo = val2;
                else if(key2 == "dataPrenotazione")
                    dataPrenotazione = val2;
                else if(key2 == "sala")
                    sala = val2;
                else if(key2 == "utente")
                    utente = val2;
                else if(key2 == "biglietto")
                    biglietto = val2;
                else if(key2 == "posto")
                    posto = val2;
            });            
            $('#prenotazioni').append("\n\
        <tr id=\"id-" + idPrenotazione + "\">\n\
            <td><a class=\"no-color\" href=\"../dettaglio-film.html?idfilm=" + idFilm + "\">" + titolo + "</a> <small class=\"text-muted hidden-xs\">" + regista + " &middot; " + genere + " &middot; " + durata + "min</small></td>\n\
            <td class=\"text-center\">" + dataSpettacolo + "</td>\n\
            <td class=\"text-center\">" + sala + "</td>\n\
            <td class=\"text-center\">" + utente + "</td>\n\
            <td class=\"text-center\">" + dataPrenotazione + "</td>\n\
            <td class=\"text-center\">" + biglietto + "</td>\n\
            <td class=\"text-center\">" + posto + "</td>\n\
            <td class=\"text-center\"><a class=\"no-color rimuovi\" href=\"#id-" + idPrenotazione + "\" id=\"delete-" + idPrenotazione + "\">x</a></td>\n\
        </tr>\n\
                ");
        });
    });
});

$(document).on("click", "a.rimuovi", function(event) {
    var posto = event.target;
    var postoId = $(posto).attr("id").substring(7);
    $("#id-prenotazione").val(postoId);
    $("#elimina-prenotazione").modal();
});

$("#delete-form").submit(function (event) {
    event.preventDefault();
    var idPrenotazione = $("#id-prenotazione").val();
    $.ajax({
        type: "GET",
        url: "../DeletePrenotazione",
        data: "idPrenotazione=" + idPrenotazione,
        success: function(answer) {
            answer = $.trim(answer);
            if (answer == "success") {
                $('#id-' + idPrenotazione).slideUp("fast");
                $("#elimina-prenotazione").modal("hide");
            } else {
                alert("Errore");
            }
        }
    });    
});

$("#resetPassword").submit(function (event) {
    event.preventDefault();
    $("#reset-wrong-password").slideUp("fast");
    $("#reset-error").slideUp("fast");
    var email = $("#email").val();
    var password1 = $("#password1").val();
    var password2 = $("#password2").val();
    $.ajax({
        type: "GET",
        url: "resetPassword",
        data: "email=" + email + "&password1=" + password1 + "&password2=" + password2,
        success: function(answer) {
            answer = $.trim(answer);
            if (answer == "success") {
                $("#containerResetPassword").html("<div class=\"page-header col-md-6 col-md-offset-3\"><h1>Password modificata</h1></div>");
            } else if(answer == "wrong-password"){
                $("#reset-wrong-password").slideDown("slow");
            } else {
                $("#reset-error").slideDown("slow");
            }
        }
    });
});

function updatePostiAdmin (spettacolo) {
    var interval = 1000;
    setInterval(function () {
        $.getJSON("../statoPrenotazioni", "spettacolo=" + spettacolo, function (result) {
            $(".posto").each(function (i, element) {
                $(element).removeClass("occupato");
                $(element).removeClass("occupato-tmp");
                $(element).removeClass("selezionato");
                $(element).addClass("libero");
                $(element).prop('title', '');
            });
            $.each(result, function (key, val) {
                var x, y, stato, timestamp, postoName, prezzo;
                $.each(val, function (key2, val2) {
                    if (key2 == "x") {
                        if (parseInt(val2) >= 10) {
                            x = val2;
                        } else {
                            x = "0" + val2;
                        }
                    } else if (key2 == "y") {
                        y = val2.toString().toUpperCase();
                    } else if (key2 == "stato") {
                        stato = val2;
                    } else if (key2 == "timestamp") {
                        var remaining = parseInt(val2);
                        var m = Math.floor(remaining / 60);
                        var s = remaining % 60;
                        var mm = "0" + m;
                        var ss;
                        if (s < 10) {
                            ss = "0" + s;
                        } else {
                            ss = s;
                        }
                        timestamp = mm + ":" + ss;
                    } else if (key2 == "prezzo") {
                        prezzo = parseInt(val2);
                    }
                    postoName = y + x;
                });
                $(".posto").each(function (i, element) {
                    if ($(element).text() == postoName) {
                        if (stato == "occupato-tmp") {
                            $(element).removeClass("libero");
                            $(element).addClass("occupato-tmp");
                            // TODO: mostra timer
                        } else if (stato == "occupato") {
                            $(element).removeClass("libero");
                            $(element).addClass("occupato");
                            $(element).prop('title', '');
                            $(element).prop('data-original-title', '');
                        } else if (stato == "tuo") {
                            $(element).removeClass("libero");
                            $(element).addClass("selezionato");
                            $(element).prop('title', '');
                            $(element).prop('data-original-title', '');
                        } else if (stato == "tuo-tmp") {
                            $(element).removeClass("libero");
                            $(element).addClass("selezionato");
                        }
                    }
                });
            });
            interval = 1000;
        }).fail( function(d, textStatus, error) {
            interval = 5000;
        });
    }, interval);
}

// AJAX Login

$("#login-form-admin").submit(function(event) {
    event.preventDefault();
    $("#login-button").attr("disabled","disabled");
    $("#login-button").html("<i class=\"zmdi zmdi-rotate-left zmdi-hc-spin-reverse\"></i> Accesso");
    $.ajax({
        type: "POST",
        url: "../check-login",
        data: "username=" + $("#input-email").val() + "&password=" + $("#input-password").val(),
        success: function(answer) {
            answer = answer.trim();
            if(answer == "success") {
                $("#login-modal").modal("hide");
                window.location.reload();
            } else {
                $("#login-button").html("Accedi");
                $("#login-button").removeAttr("disabled");
                $("#login-modal").effect("shake");
            }
        }
    });
});


// AJAX SignUp

$("#signup-form-admin").submit(function(event) {
    event.preventDefault();
    $("#signup-existing").slideUp("fast");
    $("#signup-wrong-password").slideUp("fast");
    $("#signup-error").slideUp("fast");
    $("#signup-success").slideUp("fast");
    $("#signup-button").attr("disabled", "disabled");
    $("#signup-button").html("<i class=\"zmdi zmdi-rotate-left zmdi-hc-spin-reverse\"></i> Attendere");
    $.ajax({
        type: "POST",
        url: "../signUp",
        data: "email=" + $("#signup-email").val() + "&password1=" + $("#signup-password1").val() + "&password2=" + $("#signup-password2").val(),
        success: function(answer) {
            answer = answer.trim();
            if(answer == "success") {
                $("#signup-button").hide();
                $("#signup-success").slideDown("slow");
            } else if (answer == "existing") {
                $("#signup-existing").slideDown("slow");
                $("#signup-button").html("Registrati");
                $("#signup-button").removeAttr("disabled");
            } else if (answer == "wrong-password") {
                $("#signup-wrong-password").slideDown("slow");
                $("#signup-button").html("Registrati");
                $("#signup-button").removeAttr("disabled");
            } else {
                $("#signup-error").slideDown("slow");
                $("#signup-button").html("Registrati");
                $("#signup-button").removeAttr("disabled");
            }
        }
    });
});


// Password Recovery

$("#recovery-form-admin").submit(function(event) {
    event.preventDefault();
    $("#recovery-sent").slideUp("fast");
    $("#recovery-no-email").slideUp("fast");
    $("#recovery-error").slideUp("fast");
    $("#recovery-button").attr("disabled", "disabled");
    $("#recovery-button").html("<i class=\"zmdi zmdi-rotate-left zmdi-hc-spin-reverse\"></i> Attendere");
    $.ajax({
        type: "POST",
        url: "../recuperaPassword",
        data: "email=" + $("#recovery-email").val(),
        success: function(answer) {
            answer = answer.trim();
            if (answer == "success") {
                $("#recovery-sent").slideDown("slow");
                $("#recovery-button").hide();
                $("#recovery-cancel").text("Chiudi");
            } else if (answer == "noemail") {
                $("#recovery-no-email").slideDown("slow");
                $("#recovery-button").removeAttr("disabled");
                $("#recovery-button").html("Recupera");
            } else {
                $("#recovery-error").slideDown("slow");
                $("#recovery-button").removeAttr("disabled");
                $("#recovery-button").html("Recupera");
            }
        }
    });
});