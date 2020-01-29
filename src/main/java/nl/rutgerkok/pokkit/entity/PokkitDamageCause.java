package nl.rutgerkok.pokkit.entity;

import cn.nukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public final class PokkitDamageCause {

	public static DamageCause toBukkit(cn.nukkit.event.entity.EntityDamageEvent.DamageCause nukkit) {
		// TODO Direct mapping via DamageCause.valueOf?
		switch (nukkit) {
			case CONTACT:
				return DamageCause.CONTACT;
			case ENTITY_ATTACK:
				return DamageCause.ENTITY_ATTACK;
			case PROJECTILE:
				return DamageCause.PROJECTILE;
			case SUFFOCATION:
				return DamageCause.SUFFOCATION;
			case FALL:
				return DamageCause.FALL;
			case FIRE:
				return DamageCause.FIRE;
			case FIRE_TICK:
				return DamageCause.FIRE_TICK;
			case LAVA:
				return DamageCause.LAVA;
			case DROWNING:
				return DamageCause.DROWNING;
			case BLOCK_EXPLOSION:
				return DamageCause.BLOCK_EXPLOSION;
			case ENTITY_EXPLOSION:
				return DamageCause.ENTITY_EXPLOSION;
			case VOID:
				return DamageCause.VOID;
			case SUICIDE:
				return DamageCause.SUICIDE;
			case MAGIC:
				return DamageCause.MAGIC;
			case LIGHTNING:
				return DamageCause.LIGHTNING;
			case HUNGER:
				return DamageCause.STARVATION;
			case CUSTOM:
			default:
				return DamageCause.CUSTOM;
		}
	}

	public static EntityDamageEvent.DamageCause toNukkit(DamageCause bukkit) {
		switch (bukkit) {
			case CONTACT:
				return EntityDamageEvent.DamageCause.CONTACT;
			case ENTITY_ATTACK:
				return EntityDamageEvent.DamageCause.ENTITY_ATTACK;
			case PROJECTILE:
				return EntityDamageEvent.DamageCause.PROJECTILE;
			case SUFFOCATION:
				return EntityDamageEvent.DamageCause.SUFFOCATION;
			case FALL:
				return EntityDamageEvent.DamageCause.FALL;
			case FIRE:
				return EntityDamageEvent.DamageCause.FIRE;
			case FIRE_TICK:
				return EntityDamageEvent.DamageCause.FIRE_TICK;
			case LAVA:
				return EntityDamageEvent.DamageCause.LAVA;
			case DROWNING:
				return EntityDamageEvent.DamageCause.DROWNING;
			case BLOCK_EXPLOSION:
				return EntityDamageEvent.DamageCause.BLOCK_EXPLOSION;
			case ENTITY_EXPLOSION:
				return EntityDamageEvent.DamageCause.ENTITY_EXPLOSION;
			case VOID:
				return EntityDamageEvent.DamageCause.VOID;
			case SUICIDE:
				return EntityDamageEvent.DamageCause.SUICIDE;
			case MAGIC:
				return EntityDamageEvent.DamageCause.MAGIC;
			case LIGHTNING:
				return EntityDamageEvent.DamageCause.LIGHTNING;
			case CUSTOM:
			default:
				return EntityDamageEvent.DamageCause.CUSTOM;
		}
	}
}
