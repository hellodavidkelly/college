// file: FireProjectile.cs	
using UnityEngine;
using System.Collections;

public class FireProjectile : MonoBehaviour 
{
	public Rigidbody projectilePrefab;
	private const float MIN_Y = -1;
	private float projectileSpeed = 15f;
	
	/** shortest time between firing */
	public const float FIRE_DELAY = 0.25f;
	private float nextFireTime = 0f;
	
	void Update() {
		if( Time.time > nextFireTime )
			CheckFireKey();
	}	
	
	void CheckFireKey() {
		if( Input.GetButton("Fire1")) {
			CreateProjectile();
			
			// enssure a delay before next projectile can be fired
			nextFireTime = Time.time + FIRE_DELAY;
		}
	}
		
	void CreateProjectile() {
	    Rigidbody projectile = (Rigidbody)Instantiate(projectilePrefab, transform.position, transform.rotation);
		
	    // create and apply velocity 
		Vector3 projectileVelocity = (projectileSpeed * Vector3.forward);
		// - need to use TransformDirection() so direciton is releative to current direction camera is facing
	    projectile.velocity = transform.TransformDirection( projectileVelocity );

		Destroy( projectile.gameObject, 1.5f);
	}   
		
}
