import React, { useState } from 'react';
import styles from './PasswordReset.module.css'

function PasswordReset(){

    const [email, setEmail] = useState('');
    

    return(
        <>
            <div className={styles.resetContainer}>
                <h1>Reset your Password</h1>
                <div className={styles.email}>
                    <input
                        type="email"
                        placeholder="Email"
                        value={email}
                        onChange={e => setEmail(e.target.value)}
                    />
                </div>
                <button type="submit">Login</button>
            </div>
            
        </>
        
    );
}

export default PasswordReset;