import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails({ title, startedOn, status, coach, trainer }) {
  const titleColor = status === "Scheduled" ? "blue" : "green";

  return (
    <div className={styles.box}>
      <h3 style={{ color: titleColor }}>{title}</h3>
      <dl>
        <dt>Started On</dt>
        <dd>{startedOn}</dd>
        <dt>Current Status</dt>
        <dd>{status}</dd>
        <dt>Coach</dt>
        <dd>{coach}</dd>
        <dt>Trainer</dt>
        <dd>{trainer}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;