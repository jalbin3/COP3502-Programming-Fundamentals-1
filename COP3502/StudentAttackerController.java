package edu.ufl.cise.cs1.controllers;

import game.controllers.*;
import game.models.*;

import java.util.List;

public final class StudentAttackerController implements AttackerController
{
	private Node location;
	private boolean first;
	private boolean reverse;
	private boolean doubleReverse;

	public void init(Game game) {
		Maze maze = game.getCurMaze();
		location = maze.getInitialAttackerPosition();
	}

	public void shutdown(Game game) { }

	public int update(Game game,long timeDue) //FIX ME!
	{
		int action;
		int a, b;
		Node check;

		Attacker gator = game.getAttacker();
		List<Defender> gatorbait = game.getDefenders();

		check = gator.getLocation();

		try {
			if (check == location && !first) {
				reverse = true;
				location = gator.getLocation();
			}
			else {
				location = gator.getLocation();
				first = false;
			}

			List<Node> pills = game.getPillList();
			List<Node> powerPills = game.getPowerPillList();
			List<Integer> theMove = gator.getPossibleDirs(false);

			if (reverse) {
				action = gator.getReverse();

				reverse = false;
				doubleReverse = true;
				return action;
			}
			if (doubleReverse) {
				Node nextTest = gator.getTargetNode(pills, true);

				if (nextTest.getPathDistance(location) < 24) {
					action = gator.getNextDir(nextTest, false);
					doubleReverse = false;
					return action;
				}
				action = theMove.get(0);
				doubleReverse = false;
				return action;
			}

			for (a = 0; a < powerPills.size(); a++) {
				Node full = powerPills.get(a);
				if (full.getPathDistance(location) < 2) {
					action = gator.getNextDir(full, true);
					return action;
				}
			}

			for (b = 0; b < gatorbait.size(); b++) {
				Node rivalLocation = gatorbait.get(b).getLocation();

				if (gatorbait.get(b).getVulnerableTime() > 1 && rivalLocation.getPathDistance(location) < 25){
					action = gator.getNextDir(rivalLocation, true);
					return action;
				}
			}
			for (a = 0; a < gatorbait.size(); a++) {
				Node nextRivalLocation = gatorbait.get(a).getLocation();

				if (nextRivalLocation.getPathDistance(location) < 15) {
					action = gator.getNextDir(nextRivalLocation, false);

					return action;
				}
			}

			Node holder = gator.getTargetNode(pills, true);

			if (holder.getPathDistance(location) < 19) {
				action = gator.getNextDir(holder, true);

				return action;
			}
			action = theMove.get(0);
			return action;

		} catch (NullPointerException k) {
			action = gator.getReverse();

			doubleReverse = true;
			return action;
		}
	}


		/*int action;

		//Chooses a random LEGAL action if required.
		List<Integer> possibleDirs = game.getAttacker().getPossibleDirs(true);
		if (possibleDirs.size() != 0)
			action = possibleDirs.get(Game.rng.nextInt(possibleDirs.size()));
		else
			action = -1;

		return action;
		*/
}
//getting data
//analyzing data
//making a decision