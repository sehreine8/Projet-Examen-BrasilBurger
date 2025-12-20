using Microsoft.AspNetCore.Mvc;
using BrasilBurgerClient.Data;
using Microsoft.EntityFrameworkCore;

namespace BrasilBurgerClient.Controllers
{
    public class MenuController : Controller
    {
        private readonly ApplicationDbContext _context;

        public MenuController(ApplicationDbContext context)
        {
            _context = context;
        }

        public IActionResult Index()
        {
            var menus = _context.Menus
                .Include(m => m.Burger)
                .Include(m => m.Boisson)
                .Include(m => m.Frites)
                .ToList();

            return View(menus);
        }

        public IActionResult Details(int id)
        {
            var menu = _context.Menus
                .Include(m => m.Burger)
                .Include(m => m.Boisson)
                .Include(m => m.Frites)
                .FirstOrDefault(m => m.Id == id);

            if (menu == null)
                return NotFound();

            return View(menu);
        }

    }
}
