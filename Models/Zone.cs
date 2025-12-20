namespace BrasilBurgerClient.Models
{
    public class Zone
    {
        public int Id { get; set; }
        public string Nom { get; set; }
        public double FraisLivraison { get; set; }
        public int DelaiEstime { get; set; }
        public bool Actif { get; set; }
    }
}
