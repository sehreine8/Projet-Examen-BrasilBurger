using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using BrasilBurgerClient.Data;
using System.Linq;


namespace BrasilBurgerClient.Controllers
{
    public class HomeController : Controller
    {
        private readonly ApplicationDbContext _context;

        public HomeController(ApplicationDbContext context)
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
