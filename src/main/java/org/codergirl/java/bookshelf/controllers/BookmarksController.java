package org.codergirl.java.bookshelf.controllers;

import org.codergirl.java.bookshelf.models.Bookmark;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Sources:
 *
 * https://www.springboottutorial.com/creating-web-application-with-spring-boot
 * https://github.com/spring-projects/spring-boot/blob/v2.1.6.RELEASE/spring-boot-samples/spring-boot-sample-web-jsp/pom.xml#L6-L9
 * https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-developing-web-applications.html#boot-features-jsp-limitations
 *
 * https://education.launchcode.org/skills-back-end-java/videos/intro-to-spring-boot-views-3/
 */

@Controller
@RequestMapping("bookmarks")
public class BookmarksController {
    static HashMap<Integer, Bookmark> bookmarks;

    public BookmarksController() {
        bookmarks = new HashMap<>();
        bookmarks.put(1, new Bookmark(1,"Uno", "http://google.com"));
        bookmarks.put(2, new Bookmark(2,"JSP YouTube Videos on Luv2Code",
                "https://www.youtube.com/watch?v=40KM8IdneLg&list=PLEAQNNR8IlB588DQvb2wbKFQh2DviPApl"));
    }

    @GetMapping()
    public String listBookmarks(Model model){
        model.addAttribute(("bookmarks"), bookmarks.values());
        model.addAttribute("count", bookmarks.size());

        return "bookmarks.html";
    }

    @GetMapping("/new")
    public String newBookmarkGet(){
        return "redirect:";
    }

    @PostMapping("/new")
    public String saveAddNewBookmark(@RequestParam String title,
                                     @RequestParam String webAddress) {
        System.out.println("Saved it..." + title + " " + webAddress);

        int id = bookmarks.size() + 1;

        bookmarks.put(id, new Bookmark(id, title, webAddress));
        return "redirect:";
    }

    @GetMapping("/{id}/edit")
    public String viewBookmark(Model model, @PathVariable int id) {
        Bookmark bookmark = bookmarks.get(id);
        model.addAttribute("bookmark", bookmark);

        return "bookmark.html";
    }

    @PostMapping("/{id}/edit")
    public String editBookmark(@ModelAttribute Bookmark bookmark, @PathVariable int id) {
        bookmarks.put(id, bookmark);
        return "redirect:/bookmarks";
    }

}
