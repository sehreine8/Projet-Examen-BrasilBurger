namespace BrasilBurgerClient.Models
{
    using System.ComponentModel.DataAnnotations.Schema;
    [Table("menu")]
    public class Menu
    {
        public int Id { get; set; }
        public string Nom { get; set; }
        public int BurgerId { get; set; }
        public int BoissonId { get; set; }
        public int FritesId { get; set; }
        public double PrixTotal { get; set; }
        public string ImageUrl { get; set; }
        public string? Description { get; set; }
        public bool Archived { get; set; }
    }
}
