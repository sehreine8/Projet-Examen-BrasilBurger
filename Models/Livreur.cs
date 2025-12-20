namespace BrasilBurgerClient.Models
{
    public class Livreur
    {
        public int Id { get; set; }
        public string Nom { get; set; }
        public string Telephone { get; set; }
        public bool Disponible { get; set; }
        public int ZoneId { get; set; }
    }
}
