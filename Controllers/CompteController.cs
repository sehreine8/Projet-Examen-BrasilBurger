using Microsoft.AspNetCore.Mvc;
using BrasilBurgerClient.Models.ViewModels;

public class CompteController : Controller
{
    public IActionResult Index()
    {
        // 🔥 Données mock pour tester la vue
        var vm = new CompteViewModel
        {
            Prenom = "Rahma",
            Nom = "Koza",
            Telephone = "1234567890",

            Commandes = new List<CommandeItemVM>
            {
                new CommandeItemVM
                {
                    Id = 176566776469860,
                    Date = new DateTime(2025,12,14,2,0,0),
                    Status = "En cours",
                    Total = 17.90m,
                    QuantiteArticle = 1,
                    NomArticle = "Menu Classic Brasil",
                    AdresseLivraison = "125 Rue de la Paix, Paris"
                }
            }
        };

        return View(vm);
    }
}
