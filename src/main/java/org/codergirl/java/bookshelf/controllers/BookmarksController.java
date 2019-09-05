package org.codergirl.java.bookshelf.controllers;

import org.codergirl.java.bookshelf.dao.BookmarksDAO;
import org.codergirl.java.bookshelf.models.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @Autowired
    private BookmarksDAO bookmarksDAO;

    @GetMapping()
    public String listBookmarks(Model model){
        List<Bookmark> bookmarks = bookmarksDAO.getAll();
        model.addAttribute(("bookmarks"), bookmarks);

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

        bookmarksDAO.addBookmark(new Bookmark(-1, title, webAddress));
        return "redirect:";
    }

    @GetMapping("/{id}/edit")
    public String viewBookmark(Model model, @PathVariable int id) {
        Bookmark bookmark = bookmarksDAO.findById(id);
        model.addAttribute("bookmark", bookmark);

        return "bookmark.html";
    }

    @PostMapping("/{id}/edit")
    public String editBookmark(@ModelAttribute Bookmark bookmark, @PathVariable int id) {
        bookmarksDAO.updateBookmark(id, bookmark);
        return "redirect:/bookmarks";
    }

}
