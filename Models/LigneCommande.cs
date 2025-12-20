namespace BrasilBurgerClient.Models
{
    public class LigneCommande
    {
        public int Id { get; set; }
        public int CommandeId { get; set; }
        public int MenuId { get; set; }
        public int Quantite { get; set; }
        public double PrixUnitaire { get; set; }
    }
}
