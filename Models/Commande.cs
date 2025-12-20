using System;

namespace BrasilBurgerClient.Models
{
    public class Commande
    {
        public int Id { get; set; }
        public int ClientId { get; set; }
        public int ZoneId { get; set; }
        public int? LivreurId { get; set; }
        public DateTime DateCommande { get; set; }
        public double MontantTotal { get; set; }
        public string Statut { get; set; }
    }
}
