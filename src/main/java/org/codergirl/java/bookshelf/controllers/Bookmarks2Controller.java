package org.codergirl.java.bookshelf.controllers;

import org.codergirl.java.bookshelf.models.Bookmark;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

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
public class Bookmarks2Controller {
    static ArrayList<Bookmark> bookmarks;

    public Bookmarks2Controller() {
        bookmarks = new ArrayList<Bookmark>();
        bookmarks.add(new Bookmark("Uno", null));
        bookmarks.add(new Bookmark("JSP YouTube Videos on Luv2Code",
                "https://www.youtube.com/watch?v=40KM8IdneLg&list=PLEAQNNR8IlB588DQvb2wbKFQh2DviPApl"));
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public String listBookmarks(Model model){
        model.addAttribute(("bookmarks"), bookmarks);
        model.addAttribute("count", bookmarks.size());

        return "bookmarks";
    }

    @RequestMapping(value="new", method = RequestMethod.GET)
    public String newBookmarkGet(){
        return "redirect:";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String saveAddNewBookmark(@RequestParam String bookmarkDescription,
                                     @RequestParam String bookmarkAddress) {

        System.out.println("Saved it..." + bookmarkDescription + " " + bookmarkAddress);
        bookmarks.add(new Bookmark(bookmarkDescription, bookmarkAddress));
        return "redirect:";
    }
}
