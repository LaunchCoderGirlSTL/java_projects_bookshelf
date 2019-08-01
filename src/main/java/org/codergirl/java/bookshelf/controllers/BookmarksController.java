package org.codergirl.java.bookshelf.controllers;

import org.codergirl.java.bookshelf.models.Bookmark;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("bookmarks_tl")
public class BookmarksController {

    static ArrayList<Bookmark> bookmarks;

    public BookmarksController() {
        bookmarks = new ArrayList<Bookmark>();
        bookmarks.add(new Bookmark("Uno", null));
        bookmarks.add(new Bookmark("Two", null));
        bookmarks.add(new Bookmark("Three", null));
    }

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute(("bookmarks"), bookmarks);
        model.addAttribute("count", bookmarks.size());
        return "bookmarks/index";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newBookmarkGet(Model model) {
        model.addAttribute(("bookmarks"), bookmarks);
        model.addAttribute("count", bookmarks.size());
        return "bookmarks/index";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String saveAddNewBookmark(@RequestParam String bookmarkDescription) {
//    public String saveAddNewBookmark(@RequestParam String bookmarkDescription) {
//    servlets-api style request deferencing. Disabled in favor of using spring bindings.
//    public String saveAddNewBookmark(HttpServletRequest request){
//        String bookmarkDescription = request.getParameter("cheeseName");

        System.out.println("Saved it..." + bookmarkDescription);
        bookmarks.add(new Bookmark(bookmarkDescription, null));
        return "redirect:";
    }


}
