package codegym.controller;

import codegym.service.ProductService;
import codegym.service.ProductServiceImpl;
import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    private ProductService productService = new ProductServiceImpl();
    @GetMapping("/")
    public String show(Model model) {
        model.addAttribute("products", productService.findAll());
        return "list";
    }

    @GetMapping("/product/create")
    public String showCreate(Model model) {
        model.addAttribute("create", new Product());
        return "create";
    }

    @PostMapping("/product/save")
    public String createProduct(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int)(Math.random()*100));
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Create thanh cong");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/edit")
    public String showEdit(@PathVariable int id,Model model) {
        model.addAttribute("edit", productService.findById(id));
        return "edit";
    }

    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("success", "Cap nhat thnah cong");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/delete")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("delete", productService.findById(id));
        return "delete";
    }

    @PostMapping("/product/remove")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success", "Da xoa san pham");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/view")
    public String showView(@PathVariable int id, Model model) {
        model.addAttribute("view", productService.findById(id));
        return "view";
    }

}
