<?php

namespace App\Repository;

use App\Entity\Burger;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

class BurgerRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Burger::class);
    }

    /**
     * Création d’un burger
     */
    public function create(Burger $burger): void
    {
        $em = $this->getEntityManager();
        $em->persist($burger);
        $em->flush();
    }

    /**
     * Mise à jour d’un burger existant
     */
    public function update(): void
    {
        $this->getEntityManager()->flush();
    }

    /**
     * Burgers non archivés (pagination possible)
     */
    public function findActive(int $limit, int $offset): array
    {
        return $this->createQueryBuilder('b')
            ->where('b.archived = false')
            ->orderBy('b.id', 'DESC')
            ->setMaxResults($limit)
            ->setFirstResult($offset)
            ->getQuery()
            ->getResult();
    }

    public function countActive(): int
    {
        return (int) $this->createQueryBuilder('b')
            ->select('COUNT(b.id)')
            ->where('b.archived = false')
            ->getQuery()
            ->getSingleScalarResult();
    }

    

}
