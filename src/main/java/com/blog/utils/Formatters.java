package com.blog.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class Formatters {
    public static String formattedDate(LocalDate date) {
        String r = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // Format the date
        r = date.format(formatter);
        return r;
    }

    public static String renderPost(String text){
        Parser parser = Parser.builder().build();
        Node document = parser.parse(text);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }

}
