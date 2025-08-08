import styles from './OverallContainer.module.css';


function OverallContainer(props){
    return(
        <div className={styles.container}>
            <div className={styles.insideValue}>
                <div className={styles.nameValue}>
                    <h3>{props.name}</h3>
                    <h1>{props.value}</h1>
                </div>
                <p>Overall</p>
            </div>
            <div className={styles.naviagetIcon}>
                <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1.5em" viewBox="0 0 12 24">
	                <path fill="#0D4F45" fill-rule="evenodd" d="M10.157 12.711L4.5 18.368l-1.414-1.414l4.95-4.95l-4.95-4.95L4.5 5.64l5.657 5.657a1 1 0 0 1 0 1.414" />
                </svg>
            </div>
        </div>

    );
}

export default OverallContainer;