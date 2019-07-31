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
@RequestMapping("bookmarks2")
public class Bookmarks2Controller {
    static ArrayList<Bookmark> bookmarks;

    public Bookmarks2Controller() {
        bookmarks = new ArrayList<Bookmark>();
        bookmarks.add(new Bookmark("Uno"));
        bookmarks.add(new Bookmark("Two"));
        bookmarks.add(new Bookmark("Three"));
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public String listBookmarks(Model model){
        model.addAttribute(("bookmarks"), bookmarks);
        model.addAttribute("count", bookmarks.size());

        return "bookmarks2";
    }

    @RequestMapping(value="new", method = RequestMethod.GET)
    public String listBookmarksPost(Model model){
        model.addAttribute(("bookmarks"), bookmarks);
        model.addAttribute("count", bookmarks.size());

        return "bookmarks2";
    }
    //TODO cleverly reduce the duplication with the above.

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String saveAddNewBookmark(Model model, @RequestParam String bookmarkDescription) {

        System.out.println("Saved it..." + bookmarkDescription);
        bookmarks.add(new Bookmark(bookmarkDescription));
        return listBookmarks(model);
//      TODO use an actual redirect?
    }
}
