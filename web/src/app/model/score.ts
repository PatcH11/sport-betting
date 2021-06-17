export interface Score {
  id: number;
  homeScore: number;
  awayScore: number;
}

export interface ScoreCreate {
  homeScore: number;
  awayScore: number;
}
