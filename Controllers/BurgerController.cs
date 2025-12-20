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
    }
}
