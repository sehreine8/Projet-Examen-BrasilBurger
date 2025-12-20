using Microsoft.AspNetCore.Mvc;
using BrasilBurgerClient.Data;

namespace BrasilBurgerClient.Controllers
{
    public class BurgerController : Controller
    {
        private readonly ApplicationDbContext _context;

        public BurgerController(ApplicationDbContext context)
        {
            _context = context;
        }

        public IActionResult Index()
        {
            var burgers = _context.Burgers.ToList();
            return View(burgers);
        }

        public IActionResult Details(int id)
        {
            var burger = _context.Burgers.FirstOrDefault(b => b.Id == id);

            if (burger == null)
                return NotFound();

            return View(burger);
        }

    }
}
