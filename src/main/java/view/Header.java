package view;

public class Header {
    public static String getInfoHead(String title) {
        String infoHead = "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'> "+
                "<title>"+title+"</title>";
        return infoHead;
    }
    public static String getCssLibrary() {
        String library = "    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'" +
                "          integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>" +
                "    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css'" +
                "          integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>" +
                "    <link rel='stylesheet' href='resource/base.css'>" +
                "    <link rel='stylesheet' href='resource/main.css'>";
        return library;
    }
    public static String getJsLibrary(){
        String library ="<script src='https://code.jquery.com/jquery-3.2.1.slim.min.js'" +
                "        integrity='sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN'" +
                "        crossorigin='anonymous'></script>" +
                "<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'" +
                "        integrity='sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q'" +
                "        crossorigin='anonymous'></script>" +
                "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js'" +
                "        integrity='sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl'" +
                "        crossorigin='anonymous'></script>" +
                "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>" +
                "<script src='/resource/product/main.js' charset='utf-8'></script>";
        return library;
    }

}
